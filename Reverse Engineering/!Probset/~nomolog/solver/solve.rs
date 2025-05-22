// {_sshhhhhhh_d0n7_l00k_0r_54y_4ny7h1n6_oookkkkkkkk?_}

fn dont_look_and_say_anything(enc: String) -> String {
    let mut flag = String::new();

    for i in (0..enc.len()).step_by(2) {
        let count = enc.chars()
               .nth(i).expect("omagaa")
               .to_digit(10).expect("sticnk")
               as usize;
        let character = enc.chars().nth(i + 1).expect("godtime");
        
        for _ in 0..count {
            flag.push(character);
        }
    }
    
    dbg!(flag)
}
fn main() {
    use std::io;
    
    let mut enc: String = "111312211{111312211_13211213211s13211713211h111312211_111312211d1113122110111312211n1113122117111312211_111312211l132112132110111312211k111312211_1113122110111312211r111312211_11131221151113122114111312211y111312211_1113122114111312211n111312211y1113122117111312211h31131122211n1113122116111312211_132123211o13211813211k111312211?111312211_111312211}".to_string();
    let mut inp = "heyaa mas dimaass :>".to_string();
    while inp.len() > 0 {
        enc = dont_look_and_say_anything(enc);
        println!{"return for further decryption..."}
        io::stdin().read_line(&mut inp).expect("oof");
    }
}
