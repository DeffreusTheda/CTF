#![cfg_attr(
    all(not(debug_assertions), target_os = "windows"),
    windows_subsystem = "windows"
)]

use rand::prelude::*;
use serde::Serialize;
use std::collections::HashMap;
use std::hash::{Hash, Hasher};
use std::collections::hash_map::DefaultHasher;

// Define a Matrix type for clarity
type Matrix = Vec<Vec<i32>>;

// Response structure for the UI
#[derive(Serialize)]
struct CmdResponse {
    message: String,
    success: bool,
}

// FUNCTION: XOR two matrices (binary math)
// This function performs element-wise XOR operation on two matrices
fn binary_math(a: &Matrix, b: &Matrix) -> Result<Matrix, String> {
    // Check dimensions
    if a.len() != b.len() || a[0].len() != b[0].len() {
        return Err("dimension error".to_string());
    }

    let mut res = vec![vec![0; a[0].len()]; a.len()];
    for i in 0..a.len() {
        for j in 0..a[0].len() {
            // XOR operation
            res[i][j] = a[i][j] ^ b[i][j];
        }
    }
    Ok(res)
}

// FUNCTION: Matrix multiplication
// This implements standard matrix multiplication
fn omg_real_math(a: &Matrix, b: &Matrix) -> Result<Matrix, String> {
    // Check dimensions
    if a[0].len() != b.len() {
        return Err("incompatible dimension".to_string());
    }

    let mut res = vec![vec![0; b[0].len()]; a.len()];
    for i in 0..a.len() {
        for j in 0..b[0].len() {
            for k in 0..a[0].len() {
                res[i][j] += a[i][k] * b[k][j];
            }
        }
    }
    Ok(res)
}

// FUNCTION: Turn a list into r by c matrix
// This reorganizes a list into a matrix format
fn not_math(l: &[i32], r: usize, n: usize) -> Matrix {
    // DEBUG FLAG: This function reorganizes a list into a matrix
    
    let mut list = l.to_vec();
    
    // Repeat for key if needed
    if n != 0 && n > list.len() {
        let original_len = list.len();
        let mut i = original_len;
        while i < n {
            list.push(list[i % original_len]);
            i += 1;
        }
    }

    let l_len = list.len();
    let mut c = l_len / r; // column
    if l_len as f32 / r as f32 > (l_len / r) as f32 {
        c += 1;
    }
    
    let mut res = vec![vec![0; c]; r];
    let mut i = 0;
    let mut j = 0;
    
    for x in list {
        res[i][j] = x;
        i += 1;
        if i == r {
            i = 0;
            j += 1;
            j %= c;
        }
    }
    
    res
}

// FUNCTION: Map characters into numbers
// This uses specific character mappings for encoding
fn basic_math(c: char) -> Result<i32, String> {
    let c_code = c as u32;
    
    if c_code >= 97 && c_code <= 122 { // a-z
        let result = (c_code - 96) as i32;
        return Ok(result);
    }
    if c_code >= 65 && c_code <= 90 { // A-Z
        let result = (c_code - 38) as i32;
        return Ok(result);
    }
    if c_code >= 48 && c_code <= 57 { // 0-9
        let result = (c_code + 19) as i32;
        return Ok(result);
    }
    
    // Special character mapping
    let map = HashMap::from([
        (33, 53),  // !
        (64, 54),  // @
        (35, 55),  // #
        (36, 56),  // $
        (37, 57),  // %
        (94, 58),  // ^
        (38, 59),  // &
        (42, 60),  // *
        (34, 61),  // "
        (63, 62),  // ?
        (58, 63),  // :
        (59, 64),  // ;
        (47, 65),  // /
        (92, 66),  // \
        (32, 77),  // (space)
        (123, 78), // {
        (125, 79), // }
        (95, 80),  // _
    ]);

    match map.get(&(c_code as i32)) {
        Some(&value) => {
            Ok(value)
        },
        None => {
            Err(format!("unmapped: {}", c))
        },
    }
}

// FUNCTION: Calculate hash value
// This generates a deterministic hash from a string
fn calculate_hash(input: &str) -> u64 {
    // DEBUG FLAG: This function calculates hash value
    
    let mut hasher = DefaultHasher::new();
    input.hash(&mut hasher);
    let hash = hasher.finish();
    
    hash
}

// FUNCTION: Process information (main operation)
// This is our main processing function exposed to the UI
#[tauri::command]
fn process_information(name: &str, password: &str, repassword: &str) -> CmdResponse {
    if name.is_empty() || password.is_empty() || repassword.is_empty() {
        return CmdResponse {
            message: "All fields must be filled!".to_string(),
            success: false,
        };
    }

    // Password strength requirement
    let n = password.len();
    if n < 8 || n < name.len() {
        return CmdResponse {
            message: "Password it too short!".to_string(),
            success: false,
        }
    }

    let mut has_digit = false;
    let mut has_lower = false;
    let mut has_upper = false;
    let mut has_symbol = false;
    for ch in password.chars() {
        if ch.is_ascii_digit() { has_digit = true; }
        if ch.is_ascii_lowercase() { has_lower = true; }
        if ch.is_ascii_uppercase() { has_upper = true; }
        if ch.is_ascii_punctuation() { has_symbol = true; }
        if ch.is_ascii_whitespace() {
            return CmdResponse {
                message: "No space is allowed in the password!".to_string(),
                success: false,
            }
        }
    }
    if !has_digit { return CmdResponse {
        message: "Password must contain at least one digit!".to_string(),
        success: false,
    } }
    if !has_lower { return CmdResponse {
        message: "Password must contain at least one lowercase character!".to_string(),
        success: false,
    } }
    if !has_upper { return CmdResponse {
        message: "Password must contain at least one uppercase character!".to_string(),
        success: false,
    } }
    if !has_symbol { return CmdResponse {
        message: "Password must contain at least one symbol!".to_string(),
        success: false,
    } }

    let flag_extended = format!("{}{}", password, "?".repeat(n));
    let re_extended = format!("{}{}", "?".repeat(n), repassword);
    
    // Check if passwords match
    if &flag_extended[..n] != &re_extended[n..] {
        return CmdResponse {
            message: "Passwords is not the same!".to_string(),
            success: false,
        };
    }

    let key_result: Result<Vec<i32>, String> = name.chars().map(basic_math).collect();
    let flag_result: Result<Vec<i32>, String> = flag_extended.chars().map(basic_math).collect();

    let key = match key_result {
        Ok(k) => {
            k
        },
        Err(e) => {
            return CmdResponse { message: e, success: false };
        },
    };
    
    let flag = match flag_result {
        Ok(f) => {
            f
        },
        Err(e) => {
            return CmdResponse { message: e, success: false };
        },
    };

    // Into matrix
    let key_matrix = not_math(&key, 3, flag.len());
    let flag_matrix = not_math(&flag, 3, 0);

    let flag_xor = match binary_math(&flag_matrix, &key_matrix) {
        Ok(m) => {
            m
        },
        Err(e) => {
            return CmdResponse { message: e, success: false };
        },
    };

    // Random operations with fixed seed
    let seed = calculate_hash("I dare you to solve this with a GDC calculator");
    let mut rng = StdRng::seed_from_u64(seed);
    let cipher_vals: Vec<i32> = (0..9).map(|_| {
        rng.gen_range(0..10)
    }).collect();
    
    let cipher = not_math(&cipher_vals, 3, 0);

    let final_matrix = match omg_real_math(&cipher, &flag_xor) {
        Ok(m) => {
            m
        },
        Err(e) => {
            return CmdResponse { message: e, success: false };
        },
    };

    CmdResponse {
        message: format!("{:?}", final_matrix),
        success: true,
    }
}

fn main() {
    tauri::Builder::default()
        .invoke_handler(tauri::generate_handler![process_information])
        .run(tauri::generate_context!())
        .expect("Error while running tauri application");
}