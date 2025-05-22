use regex::Regex;
use std::collections::HashMap;

static VERSION: &str = "ko";

fn swap_consonant(word: String) -> String {
    let mut chars: Vec<char> = word.chars().collect();
    let vowels = ['a', 'e', 'i', 'o', 'u'];
    let mut second_consonant_end = 2;

    let mut second_consonant = Vec::new();
    while !vowels.contains(&chars[second_consonant_end]) {
        second_consonant.push(chars[second_consonant_end]);
        second_consonant_end += 1;
    }
    let mut first_consonant = Vec::new();
    let mut first_consonant_end = 0;
    while !vowels.contains(&chars[first_consonant_end]) {
        first_consonant.push(chars[first_consonant_end]);
        first_consonant_end += 1;
    }
    let mut result = second_consonant.clone();
    result.append(&mut chars[first_consonant.len()..first_consonant_end+1].to_vec());
    result.append(&mut first_consonant);
    result.append(&mut chars[2+second_consonant.len()..].to_vec());

    result.iter().collect()
}

fn ko_first_syllable(word: &str) -> String {
    let pattern = r"^([bcdfghjklmnpqrstvwxyz]*?[aeiouy]{1,2}[bcdfghjklmnpqrstvwxyz]{1,2})";
    let re = Regex::new(pattern).unwrap();

    if let Some(captures) = re.captures(word) {
        if let Some(matched) = captures.get(1) {
            return matched.as_str().to_string()
        }
    }
    "".to_string()
}

fn ko(str: String) -> String {
    let first_syllable = ko_first_syllable(&str);

    let mut result = VERSION.to_string();
    if vec!['a','i','u','e','o'].contains(&first_syllable.chars().nth(0).unwrap()) {
        result.push_str("'");
    }
    result.push_str(first_syllable.as_str());

    swap_consonant(result)
}

fn not_leet(str: &str) -> String {
    let mut iter = str;
    let mut result: Vec<char> = Vec::new();
    let deleet = HashMap::from([
        ('0', 'o'),
        ('1', 'i'),
        ('2', 'z'),
        ('3', 'e'),
        ('4', 'a'),
        ('5', 's'),
        ('6', 'g'),
        ('7', 't'),
        ('9', 'p'),
    ]);

    for c in iter.chars() {
        if deleet.contains_key(&c) {
            result.push(deleet.get(&c).unwrap().clone());
        } else {
            result.push(c);
        }
    }

    String::from_iter(result)
}

fn main() {
    let test = ["preman", "bencong"];
    for word in test {
        println!("{}", ko(not_leet(word)));
    }
}
