// {_sshhhhhhh_d0n7_l00k_0r_54y_4ny7h1n6_oookkkkkkkk?_}

fn new_vec() -> Vec<String> {
    Vec::new()
}

fn new_string() -> String {
    String::new()
}

fn loopie(mut result: Vec<String>, n: usize) -> Vec<String> {
    for _ in 1..n {
        let prev = result.last().unwrap();
        let mut next = new_string();
        let mut count = 1;
        let mut current_digit = prev.chars().next().unwrap();
        
        for c in prev.chars().skip(1) {
            if c == current_digit {
                count += 1;
            } else {
                next.push_str(&count.to_string());
                next.push(current_digit);
                current_digit = c;
                count = 1;
            }
        }
        
        next.push_str(&count.to_string());
        next.push(current_digit);
        result.push(next);
    }
    
    result
}

fn look_and_say(start: &str, n: usize) -> Vec<String> {
    let mut result = new_vec();
    if n == 0 {
        return result;
    }
    
    result.push(start.to_string());
    
    loopie(result, n)
}

#[cfg(solver = "1")]
fn dont_look_and_say_anything(enc: String) -> String {
    let mut flag = String::new();
    let chars: Vec<char> = enc.chars().collect();
    
    for i in (0..chars.len()).step_by(2) {
        if i + 1 < chars.len() {
            let count = chars[i].to_digit(10).unwrap_or(0) as usize;
            let character = chars[i + 1];
            
            for _ in 0..count {
                flag.push(character);
            }
        } else {
            return enc;
        }
    }
    
    dont_look_and_say_anything(flag)
}
fn main() {
    use std::io::{self, Write};
    
    print!("vinnie: 😭 g what are you doin in my room 💀💀\n.effie: ");
    io::stdout().flush().expect("{_d0_m3_4_f4v0r_}");
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("{_n0_c0n73x7_}");
    let start = input.trim();
    
    print!(".effie: dw i aint doin ya dirty if im paid first ;>\nvinnie: yeah aight here some $");
    io::stdout().flush().expect("{_y34h_416h7_}");
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("{_4_P4P_P4P!_}");
    let n: usize = input.trim().parse().expect("{_74lk1n_0n_my_6uy5_}");
    
    let sequence = look_and_say(start, n/100);
    println!(".effie: {}", sequence[sequence.len()-1]);
    println!("vinnie: what?? i cant understand this! anyway idk help >_<");
    #[cfg(solver = "1")] {
        for (i, term) in sequence.iter().enumerate() {
          println!("{}: {}", i + 1, term);
        }
        println!("{}", dont_look_and_say_anything(sequence[sequence.len()-1].clone()));
    }
}
