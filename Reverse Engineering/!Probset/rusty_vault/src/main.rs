use std::io::{self, Write};
use std::env;

// Obfuscated strings (simple XOR). In a real CTF, this might be more complex.
const OBF_KEY: u8 = 0xAC;
const OBF_PROMPT: [u8; 19] = [
    0xE4 ^ OBF_KEY, 0xBF ^ OBF_KEY, 0xB8 ^ OBF_KEY, 0xA7 ^ OBF_KEY, 0xA5 ^ OBF_KEY,
    0xA1 ^ OBF_KEY, 0xAF ^ OBF_KEY, 0xB3 ^ OBF_KEY, 0xAA ^ OBF_KEY, 0xA7 ^ OBF_KEY,
    0xB3 ^ OBF_KEY, 0xA1 ^ OBF_KEY, 0xBA ^ OBF_KEY, 0xA7 ^ OBF_KEY, 0xB9 ^ OBF_KEY,
    0xAB ^ OBF_KEY, 0xBB ^ OBF_KEY, 0xA1 ^ OBF_KEY, 0xEA ^ OBF_KEY,
]; // "Enter the master key: "
const OBF_SUCCESS: [u8; 21] = [
    0xE6 ^ OBF_KEY, 0xA7 ^ OBF_KEY, 0xBA ^ OBF_KEY, 0xBA ^ OBF_KEY, 0xA7 ^ OBF_KEY,
    0xA5 ^ OBF_KEY, 0xB8 ^ OBF_KEY, 0xAB ^ OBF_KEY, 0xEC ^ OBF_KEY, 0xED ^ OBF_KEY,
    0xF3 ^ OBF_KEY, 0xF3 ^ OBF_KEY, 0xE6 ^ OBF_KEY, 0xBB ^ OBF_KEY, 0xAD ^ OBF_KEY,
    0xA7 ^ OBF_KEY, 0xED ^ OBF_KEY, 0xF5 ^ OBF_KEY, 0xE3 ^ OBF_KEY, 0xE3 ^ OBF_KEY,
    0xF9 ^ OBF_KEY,
]; // "Access Granted! Flag{...}" - You need to figure out the real flag!
const OBF_FAILURE: [u8; 16] = [
    0xE8 ^ OBF_KEY, 0xBF ^ OBF_KEY, 0xA5 ^ OBF_KEY, 0xA7 ^ OBF_KEY, 0xA1 ^ OBF_KEY,
    0xA1 ^ OBF_KEY, 0xAF ^ OBF_KEY, 0xB3 ^ OBF_KEY, 0xBD ^ OBF_KEY, 0xA7 ^ OBF_KEY,
    0xBB ^ OBF_KEY, 0xA7 ^ OBF_KEY, 0xAD ^ OBF_KEY, 0xF3 ^ OBF_KEY, 0xF3 ^ OBF_KEY,
    0xF9 ^ OBF_KEY,
]; // "Incorrect key..."

// Decrypt helper
#[inline(never)] // Prevent excessive inlining to make RE slightly easier in *some* ways
fn deobfuscate(data: &[u8]) -> String {
    data.iter().map(|b| (b ^ OBF_KEY) as char).collect()
}

// Stage 1: Basic input transformation and length check
// Expected input length: 32 hex chars (16 bytes)
#[inline(always)] // Encourage inlining to mix this logic with others
fn stage1_transform_check(input: &str) -> Option<Vec<u8>> {
    if input.len() != 32 {
        return None;
    }
    // Hex decode - Do it manually to avoid obvious library calls
    let mut bytes = Vec::with_capacity(16);
    let mut chars = input.chars();
    while let (Some(h1), Some(h2)) = (chars.next(), chars.next()) {
        let byte_str = format!("{}{}", h1, h2);
        if let Ok(byte) = u8::from_str_radix(&byte_str, 16) {
            bytes.push(byte);
        } else {
            return None; // Invalid hex
        }
    }
    if bytes.len() == 16 { Some(bytes) } else { None }
}

// Stage 2: Custom checksum/hash-like algorithm
// Operates on the 16 bytes from stage 1
#[inline(never)]
fn stage2_checksum(data: &[u8]) -> u64 {
    let mut state: u64 = 0xDEADBEEFCAFEBABE; // Initial state
    let poly: u64 = 0xC96C5795D7870F42; // Polynomial for CRC-like step

    for &byte in data.iter() {
        state ^= (byte as u64) << 56; // XOR byte into the top
        for _ in 0..8 { // Process 8 bits
            if state & (1 << 63) != 0 { // Check top bit
                state = (state << 1) ^ poly;
            } else {
                state <<= 1;
            }
        }
    }
    // Mix the final state a bit
    state.rotate_left(13).wrapping_add(0xBAADF00D)
}

// Stage 3: Complex byte manipulation and state machine
// Uses the 16 bytes and the checksum result
#[inline(never)]
fn stage3_state_machine(data: &[u8], checksum: u64) -> [u8; 16] {
    let mut state = [0u8; 16];
    let key_bytes = checksum.to_le_bytes(); // Use checksum as a key schedule base

    // Initialize state with a permutation based on key
    for i in 0..16 {
        state[i] = data[i ^ (key_bytes[i % 8] as usize % 16)];
    }

    // Multiple rounds of transformation
    for round in 0..4 {
        let round_key_idx = round * 2;
        let round_key = u16::from_le_bytes([key_bytes[round_key_idx], key_bytes[round_key_idx + 1]]);
        let mut next_state = [0u8; 16];

        // Non-linear transformation mixing bytes
        for i in 0..16 {
            let prev_idx = (i + 15) % 16; // Previous byte index
            let next_idx = (i + 1) % 16; // Next byte index

            let mut val = state[i] as u16;
            val = val.wrapping_add(state[prev_idx] as u16);
            val = val.rotate_left( (state[next_idx] % 8) as u32 ); // Rotate based on neighbour
            val ^= round_key; // XOR with round key
            val = val.wrapping_mul(0x1337); // Multiply

            next_state[i] = (val & 0xFF) as u8 ^ (val >> 8) as u8; // Fold high bits into low bits
            next_state[i] ^= state[ (i + (round_key as usize % 16)) % 16 ]; // XOR with another state byte based on key
        }
         // Permutation step within the round
        for i in 0..8 {
             next_state.swap(i, 15 - i);
        }
        state = next_state;
    }

    state // Return the final state
}

// Target state the machine must reach
// This is the result of running the *correct* 16-byte input through stage3
// You will need to reverse the process or brute force the input that produces this.
const TARGET_STATE: [u8; 16] = [
    0x7A, 0xE1, 0x9B, 0x3F, 0x8C, 0xD0, 0x44, 0x5A,
    0x6B, 0x1F, 0x2E, 0x77, 0x90, 0x5C, 0x88, 0xD3
];

// Anti-debug placeholder - In a real CTF, this would contain actual checks
#[inline(never)]
fn check_debugger() {
    // On Linux: check /proc/self/status for TracerPid
    // On Windows: IsDebuggerPresent()
    // Could also use timing checks, specific CPU instructions (icebp), etc.
    // For this example, it does nothing.
    let _nothing = std::time::Instant::now();
}

fn main() {
    check_debugger();

    // Get input from command line argument or stdin
    let input_key = match env::args().nth(1) {
        Some(arg) => arg,
        None => {
            print!("{}", deobfuscate(&OBF_PROMPT));
            io::stdout().flush().unwrap();
            let mut buffer = String::new();
            io::stdin().read_line(&mut buffer).unwrap();
            buffer.trim().to_string()
        }
    };

    // --- Validation Pipeline ---

    // Stage 1
    let bytes = match stage1_transform_check(&input_key) {
        Some(b) => b,
        None => {
            println!("{}", deobfuscate(&OBF_FAILURE));
            return;
        }
    };

    // Stage 2
    let checksum = stage2_checksum(&bytes);

    // Introduce a dummy check based on checksum to complicate control flow graph
    // This check is *always true* for any 16-byte input from stage1,
    // but it forces the reverser to analyze stage2 somewhat.
    if checksum.count_ones() + checksum.count_zeros() != 64 {
         // This branch is unreachable if stage 1 passed and stage 2 ran
         println!("Internal state error! Tampering detected?");
         return;
    }

    // Stage 3
    let final_state = stage3_state_machine(&bytes, checksum);

    // Final Check
    if final_state == TARGET_STATE {
        // Construct the flag dynamically ONLY on success.
        // The actual flag string isn't easily found in the binary dump.
        let part1 = "Acc3ss_Gr4nted!";
        let part2 = format!("{:016x}", checksum); // Include checksum in the flag
        let flag = format!("Flag{{Rusted_V4ult_{}_{}}}", part1, &part2[0..8]);
        // Replace the placeholder success message with the real one.
        let success_msg = deobfuscate(&OBF_SUCCESS);
        println!("{}", success_msg.replace("Flag{...}", &flag));
    } else {
        println!("{}", deobfuscate(&OBF_FAILURE));
    }
}