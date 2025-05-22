use std::fs::File;
use std::path::Path;
use std::io::{self, Write, BufRead};
use std::thread::sleep;
use std::time::{Duration, SystemTime};

// {_l375_l053_0ur_m1nd_4nd_60_fuck1n6_}

fn next_power_of_two(n: usize) -> usize {
  if n == 0 {
    return 1;
  }
  
  let mut power = 1;
  while power < n {
    power *= 2;
  }
  power
}

fn bitonic_sort_padded(arr: &mut Vec<u8>) -> Vec<u8> {
  let original_len = arr.len();
  let padded_len = next_power_of_two(original_len);
  let pad_len = padded_len - original_len;
  
  arr.resize(padded_len, 0);
  
  let log = bitonic_sort(arr);
  
  arr.drain(..pad_len); // Truncate back to original length

  log
}

fn bitonic_sort(arr: &mut [u8]) -> Vec<u8> {
  let n = arr.len();
  let mut log = Vec::new();
  
  // k is doubled every iteration
  let mut k = 2;
  while k <= n {
    // j is halved at every iteration
    let mut j = k / 2;
    while j > 0 {
      for i in 0..n {
        let l = i ^ j;
        
        if l > i {
          let should_swap = (i & k == 0 && arr[i] > arr[l]) || (i & k != 0 && arr[i] < arr[l]);
          if should_swap {
            arr.swap(i, l);
            log.push(1);
          } else {
            log.push(0);
          }
        }
      }
      
      j /= 2;
    }
    
    k *= 2;
  }

  log
}

fn write_log(bytes: &[u8]) {
  let path = Path::new(".mutualdisrecpect");
  let mut file = File::create(path).expect("bad apple!!");
  file.write_all(bytes).expect("bad apple!");
}

fn bits_to_byte(bits: &[u8]) -> u8 {
  let mut byte = 0u8;
  for &bit in bits {
    byte = (byte << 1) | bit;
  }
  byte
}
fn to_uni(bits: Vec<u8>) -> String {
  let space = 10;
  let len = bits.len() + space - (bits.len() % space);
  assert_eq!(len % space, 0);
  let mut drainer = bits.clone();
  drainer.resize(len, 0);
  let mut prep = Vec::new();
  while !drainer.is_empty() {
    prep.append(&mut Vec::from([1, 1, 0]));
    prep.append(&mut drainer.drain(..5).collect());
    prep.append(&mut Vec::from([1, 0]));
    prep.append(&mut drainer.drain(..5).collect());
    prep.append(&mut Vec::from([0]));
  }
  let mut result: Vec<char> = Vec::new();
  for i in (0..prep.len()).step_by(16) {
    let byte1 = bits_to_byte(&prep[i..i+8]);
    let byte2 = bits_to_byte(&prep[i+8..i+16]);

    assert!((byte1 & 0b11100000) == 0b11000000 && (byte2 & 0b11000000 == 0b10000000));
    let mut codepoint = (byte1 as u32) << 8 | (byte2 as u32);
    if codepoint >= 0xD800 && codepoint <= 0xDFFF {
      let fix = if codepoint > 0xDBFF {0x400} else {0};
      let w1 = (codepoint - fix) & 0b1111111111;
      codepoint = 0x10000 + w1;
    }
    result.push(char::from_u32(codepoint).unwrap());
  }
  result.into_iter().collect()
}

fn intro() {
  println!("You descend down to a large, grey-tinted, tunnel-like room with a great gate in front.");
  println!("A screen ahead displays buttons to unlock the three locks keeping the gate closed.\n\n\n\n\n");

  let mut locks = vec!["LOCK [A]", "LOCK [B]", "LOCK [C]"];
  let mut unlock_index = 0;
  let stdin = io::stdin();
  let mut stdout = io::stdout();
  let mut now = SystemTime::now();
  
  loop {
    // Move cursor up 3 lines and print current state
    print!("\x1B[4A");
    for line in &locks {
      println!("{}", line);
    }
    stdout.flush().unwrap();
    
    // Exit if all locks are unlocked
    if unlock_index >= locks.len() {
      break;
    }
    
    // Wait for Enter
    let _ = stdin.lock().lines().next().unwrap();

    // Time based! Hehe
    if now.elapsed().expect("time moves faster when you're older.").as_secs() as usize != unlock_index {
      eprintln!("You pressed the button, but it won't unlock...");
      std::process::exit(1);
    }
    
    // Unlock the next lock
    locks[unlock_index] = "UNLOCKED";
    unlock_index += 1;
    
    sleep(Duration::from_millis(50));
  }

  println!("\nYou unlocked them all, opening the great door to the next area,");
  println!("housing another screen with a boss gate blocking the path.\n\n\n\n");

  locks = vec![" 🤚 ", "OPEN"];
  unlock_index = 0;
  now = SystemTime::now();  

  loop {
    print!("\x1B[3A");
    for line in &locks {
      println!("{}", line);
    }
    stdout.flush().unwrap();
    
    let _ = stdin.lock().lines().next().unwrap();

    if unlock_index == 1 {
      print!("\x1B[3A");
      if (now.elapsed().expect("everywhere at the end of time").as_secs() as usize) < 3 {
        println!("FOLLOW PROTOCOL
             
DO \x1B[31mNOT\x1B[39m APPROACH IT

DO \x1B[31mNOT\x1B[39m LET IT
LOOK AT YOU

STAY VIGILANT,
AND MOST IMPORTANTLY

h a v e  f u n !");
      } else {
        println!("HA           
HA         
HA
HA
HA
HA

\x1B[31ma s  i f
y o u  h a d
a  c h o i c e\x1B[39m");
      }
    }
    
    locks[0] = "ARE YOU SURE?";
    locks[1] = "   V     X   ";
    unlock_index += 1;

    if unlock_index >= locks.len() {
      break;
    }
  }

  sleep(Duration::from_millis(500));
  
  println!("\nRegardless of your answer, the door open anyway.");
  println!("It leads to a dark corridor containing a Terminal.\n");
  print!("> ");
  stdout.flush().unwrap();
}

fn main() -> Result<(), Box<dyn std::error::Error>> {
  intro();

  let mut input = String::new();
  io::stdin().read_line(&mut input).unwrap();

  let mut array: Vec<u8> = input.trim().bytes().collect();
  // println!("Original array: {:?}", array);

  let log = bitonic_sort_padded(&mut array);
  write_log(&log);
  // println!("Sorted array: {:?}", array);
  let uni = to_uni(log);
  println!("{:?}", uni);

  Ok(())
}