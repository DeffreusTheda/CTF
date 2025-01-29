use std::io::{self};
use std::collections::HashMap;
// inspo: https://www.youtube.com/watch?v=8VbwWVvw-zI

fn init_tables() -> HashMap<char, Vec<&'static str>> {
        let mut tables = HashMap::new();
        tables.insert('a', vec!["abl", "abo", "abr", "abs", "acc", "ach", "acr", "act", "add", "adm", "adv", "aer", "aff", "afr", "aft", "aga", "age", "ago", "ahe", "air", "ali", "all", "alm", "alo", "alr", "als", "alt", "alw", "am ", "ame", "amo", "and", "ang", "ani", "ano", "ans", "any", "apa", "app", "apr", "are", "arg", "arm", "arr", "art", "asi", "ask", "asl", "ate", "atm", "att", "aud", "aug", "aut", "ave", "avo", "awa"]);
        tables.insert('c', vec!["cak", "cal", "cam", "can", "cap", "car", "cas", "cat", "cau", "cen", "cer", "cha", "che", "chi", "cho", "chi", "chu", "cir", "cit", "cla", "cle", "cli", "clo", "coa", "cof", "coi", "col", "com", "con", "coo", "cop", "cor", "cos", "cou", "cov", "cow", "cre", "cri", "cro", "cry", "cup", "cur", "cus", "cut"]);
        tables.insert('b', vec!["bab", "bac", "bad", "bag", "bal", "ban", "bas", "bat", "be ", "bea", "bec", "bed", "bee", "bef", "beg", "beh", "bel", "bes", "bet", "bey", "bic", "big", "bik", "bil", "bir", "bit", "bla", "ble", "blo", "blu", "boa", "bod", "bon", "boo", "bor", "bot", "bou", "box", "boy", "bra", "bre", "bri", "bro", "bui", "bur", "bus", "but", "buy", "by "]);
        tables.insert('e', vec!["eac", "ear", "eas", "eat", "edu", "eff", "egg", "eig", "eit", "ele", "els", "emp", "end", "ene", "eng", "enj", "eno", "ent", "equ", "err", "esp", "eur", "eve", "exa", "exc", "exe", "exp", "eye"]);
        tables.insert('d', vec!["dad", "dai", "dam", "dan", "dar", "dat", "dau", "day", "dea", "dec", "dee", "def", "deg", "del", "dem", "den", "dep", "des", "det", "dev", "dic", "did", "die", "dif", "dig", "din", "dir", "dis", "div", "do ", "doc", "doe", "dog", "dol", "don", "doo", "dou", "dow", "doz", "dra", "dre", "dri", "dro", "dru", "dry", "due", "dur", "dus", "dut"]);
        tables.insert('g', vec!["gai", "gam", "gar", "gas", "gat", "gav", "gen", "ger", "get", "gir", "giv", "gla", "go ", "god", "goi", "gon", "goo", "got", "gov", "gra", "gre", "gro", "gua", "gue", "gui", "gun"]);
        tables.insert('f', vec!["fac", "fai", "fal", "fam", "far", "fas", "fat", "fea", "feb", "fed", "fee", "fel", "few", "fie", "fif", "fig", "fil", "fin", "fir", "fis", "fiv", "fix", "fla", "fle", "fli", "flo", "fly", "fol", "foo", "for", "fou", "fra", "fre", "fri", "fro", "fru", "ful", "fun", "fut"]);
        tables.insert('i', vec!["i  ", "ice", "ide", "if ", "ima", "imm", "imp", "in ", "inc", "ind", "inf", "ins", "int", "inv", "iro", "is ", "isl", "it ", "its"]);
        tables.insert('h', vec!["hab", "had", "hai", "hal", "han", "hap", "har", "has", "hat", "hav", "he ", "hea", "hei", "hel", "her", "hi ", "hid", "hig", "hil", "him", "hir", "his", "hit", "hol", "hom", "hon", "hop", "hor", "hos", "hot", "hou", "how", "hum", "hun", "hur", "hus"]);
        tables.insert('k', vec!["kee", "kep", "key", "kic", "kil", "kin", "kit", "kne", "kni", "kno", "kab", "kad", "kai", "kak", "kan", "kar", "kas", "kat", "kau", "kaw", "kay", "kaz", "kea", "ked", "kef", "keg", "ken", "kes", "ket", "kev", "kib", "kie", "kif", "kig", "kik", "kim", "kin", "kis", "kit", "kiv", "koc", "kon", "koo", "kos", "kot", "kou", "kov", "kow", "kun", "kyi", "kac", "kad", "kag", "kai", "kaj", "kak", "kan", "kap", "kar", "kat", "kay", "ke ", "kea", "ked", "kee", "kem", "ken", "kes", "ket", "kid", "kig", "kil", "kin", "kis", "kod", "kom", "kon", "koo", "kor", "kos", "kot", "kou", "kov", "kuc", "kum", "kus", "ky ", "kys", "kam", "kar", "kat", "kea", "kec", "kee", "kei", "kev", "kew", "kex", "kic", "kig", "kin", "ko ", "kob", "koi", "kon", "koo", "kor", "kos", "kot", "kov", "kow", "kum", "kbj", "k'c", "kct", "kf ", "kff", "kft", "kh ", "kil", "kka", "kld", "kn ", "knc", "kne", "knl", "kpe", "kpi", "kpp", "kr ", "kra", "krd", "kth", "kur", "kut", "kve", "kwn"]);
        tables.insert('j', vec!["jan", "jap", "job", "joi", "jud", "jul", "jum", "jun", "jus"]);
        tables.insert('q', vec!["qua", "que", "qui"]);
        tables.insert('p', vec!["pac", "pag", "pai", "pap", "par", "pas", "pat", "pay", "pea", "pen", "peo", "per", "pho", "pic", "pie", "pin", "pip", "pla", "ple", "poc", "poi", "pol", "poo", "pop", "pos", "pot", "pou", "pow", "pra", "pre", "pri", "pro", "pub", "pul", "pup", "pur", "pus", "put"]);
        tables.insert('s', vec!["sad", "saf", "sai", "sal", "sam", "san", "sat", "sav", "saw", "say", "sce", "sch", "sci", "sco", "sea", "sec", "see", "sel", "sen", "sep", "ser", "set", "sev", "sex", "sha", "she", "shi", "sho", "shu", "sic", "sid", "sig", "sil", "sim", "sin", "sis", "sit", "six", "siz", "ski", "sky", "sle", "sli", "slo", "sma", "sme", "smi", "smo", "sno", "so ", "soa", "soc", "sof", "soi", "sol", "som", "son", "soo", "sor", "sou", "spa", "spe", "spi", "spo", "spr", "squ", "sta", "ste", "sti", "sto", "str", "stu", "sty", "sub", "suc", "sud", "suf", "sug", "sum", "sun", "sup", "sur", "swa", "swe", "swi", "swu", "sys"]);
        tables.insert('r', vec!["rac", "rad", "rai", "ran", "rap", "rat", "rea", "rec", "red", "ref", "reg", "rel", "rem", "rep", "req", "res", "ret", "ric", "rid", "rig", "rin", "ris", "riv", "roa", "roc", "rod", "rol", "roo", "ros", "rou", "row", "rul", "run", "rus"]);
        tables.insert('u', vec!["una", "unc", "und", "uni", "unl", "unt", "up ", "upo", "us ", "use", "usu"]);
        tables.insert('t', vec!["tab", "tak", "tal", "tas", "tau", "tax", "tea", "tee", "tel", "tem", "ten", "ter", "tes", "tha", "the", "thi", "tho", "thr", "thu", "tic", "tie", "til", "tim", "tir", "tit", "to ", "tod", "tog", "tol", "tom", "ton", "too", "top", "tor", "tot", "tou", "tow", "tra", "tre", "tri", "tro", "tru", "try", "tue", "tur", "tv ", "twe", "twi", "two", "tyi", "typ"]);
        tables.insert('v', vec!["val", "var", "veg", "ver", "vie", "vil", "vis", "voi", "vol", "vot", "vai", "vak", "val", "van", "var", "vas", "vat", "vav", "vay", "ve ", "vea", "ved", "vee", "vei", "vel", "ven", "ver", "ves", "vet", "vha", "vhe", "vhi", "vho", "vhy", "vid", "vif", "vil", "vin", "vir", "vis", "vit", "viv", "vok", "vom", "von", "voo", "vor", "vou", "vri", "vro", "vma"]);
        tables.insert('y', vec!["yar", "yea", "yel", "yen", "yes", "yet", "you"]);
        tables.insert('z', vec!["zer"]);
        tables.clone()
}

fn main() {
        const MAX_LENGTH: usize = 190;
        const MAX_POSSIBLE_SCORE: i32 = 1300; // placeholder value!

        let tables: HashMap<char, Vec<&str>> = init_tables();
        
        const CHARSET: &str = concat!("1234567890", "QWERTYUIOPASDFGHJKLZXCVBNM", ",.!?\"-~_';:", "qwertyuiopasdfghjklzxcvbnm");
        const WHITESPACE: &str = " \n\t\r";
        const PUNCTUATIONS: [&str; 3] = ["!", "?", "."];

        println!("
▖  ▖  ▘▗         ▖         ▖   ▗ ▗     ▌
▌▞▖▌▛▘▌▜▘█▌  ▀▌  ▌ ▛▌▌▌█▌  ▌ █▌▜▘▜▘█▌▛▘▌
▛ ▝▌▌ ▌▐▖▙▖  █▌  ▙▖▙▌▚▘▙▖  ▙▖▙▖▐▖▐▖▙▖▌ ▖

Note: EOF to end the letter.
----------------------------------------
To Bob

");

        let mut letter = String::new();
        
        while letter.len() < MAX_LENGTH {
                let mut line = String::new();
                let read = io::stdin().read_line(&mut line).expect("What's that about??");
                letter.push_str(&line);
                if letter.len() > MAX_LENGTH {
                        letter.truncate(MAX_LENGTH);
                }
                if read == 0 { 
                        break;
                }
                // let c = term.read_char();
                // if let Ok(cn) = c {
                //         letter.push(cn);
                //         print!("{}", cn);
                //         io::stdout().flush().unwrap();
                //         continue;
                // }
                // break;
        }
        if WHITESPACE.contains(&letter.chars().clone().last().expect("Eww.").to_string().as_str()) {
                letter.remove(letter.len() - 1);
        }

        let len = letter.len();
        let mut chars = letter.chars();
        let mut points = 0;
        if len == 0 { return () }
        
        // Check A: Punctuation
        // +20 IF the last character in the letter is (!), (?), or (.)
        if PUNCTUATIONS.contains(dbg!(&chars.clone().last().expect("Your handwriting is unreadable!").to_string().as_str())) {
                points += 20; println!("+ 20 (Last Char)");
        }

        // Check B: Trigram
        let mut trigram_counter = 0;

        // Check C: Starting Capital Check
        let mut is_start_ws = true;

        // Check D: Sequential Character Check
        let mut repeat_count = 0;
        let mut last_char: char = ' ';

        // Check E: Space Ratio Check
        let mut ws_count = 0;
        let mut non_ws_count = 0;
        let mut is_all_ws = true;

        // Check F: Run-on Sentence Check
        let mut is_have_punc = false;

        // Check G: Space Every 32-characters Check
        let mut group_has_space = false;

        for i in 0..len {
                let c = dbg!(chars.nth(0).expect("Your handwriting is unreadable!!"));
                // println!("NOW: {} => {}", i, c);
                if !CHARSET.contains(c.to_string().as_str()) && !WHITESPACE.contains(c.to_string().as_str()) {
                        // println!("Sorry, what's that?? I can't read that letter..");
                        break;
                }

                // Check A: Punctuation
                if PUNCTUATIONS.contains(&c.to_string().as_str()) {
                        let mut check_a = false;
                        is_have_punc = true;

                        // FOR (!), (?), or (.): +10 IF there is a capital letter 3 chars ahead ELSE -10
                        for j in 0..3 {
                                let test = dbg!(chars.clone().nth(j));
                                if let Some(cn) = test && cn.is_uppercase() {
                                        check_a = true;
                                        break;
                                }
                        }
                        if check_a {
                                points += 10; println!("+ 10 (Punch & 3 chars)");
                        } else {
                                points -= 10; println!("- 10 (Punch & 3 chars)");
                        }
                }
                
                // Check B: Trigram Check
                // FOR every word that start with a common trigram (first 3 character) DO increment _counter_
                let mut trigram = c.to_string();
                for j in 0..=1 {
                        if let Some(cn) = chars.clone().nth(j) {
                                        trigram.push(cn);
                        }
                }
                let tri = trigram.clone().as_str().to_lowercase().to_string();
                println!("TRI: {}", tri);
                // +(_counter_ * 3)
                if tri.len() == 3 {
                        let mut c = tri.clone().chars().nth(0).unwrap();
                        c.make_ascii_lowercase();
                        if match tables.get(&c) {
                                Some(table) => table.contains(&tri.as_str()),
                                None => false,
                        } {
                                trigram_counter += 1; println!("+ trigram ({})", tri);
                        }
                }
         
                // Check C: Starting Capital Check
                // +20 IF the first non-whitespace character is capitalized ELSE -10
                if is_start_ws && !c.is_whitespace() {
                        if c.is_uppercase() {
                                points += 20;
                                println!("+ 20 (first non-ws is capital)");
                        } else {
                                points -= 10;
                                println!("- 20 (first non-ws is lowercase)");
                        }
                        is_start_ws = false;
                }
                                
                // Check D: Sequential Character Check
                // -50 IF the same alphabet character is repeated 3 times consecutively
                if last_char == c {
                        dbg!(last_char == c);
                        repeat_count += 1;
                        if dbg!(repeat_count) == 3 {
                                points -= 50;
                                println!("- 50 (same alphabet 3 times)");
                                repeat_count = 1;
                        }
                } else {
                        repeat_count = 1;
                }
                last_char = c;

                // Check E: Space Ratio Check
                if c.is_whitespace() { 
                 ws_count += 1;
                 group_has_space = true;
                } else { non_ws_count += 1; }
                is_all_ws &= c.is_whitespace();
                
                // Check G: Space Every 32-characters Check
                // -20 FOR each group of 32-characters that doesn't have any whitespace
                if i % 32 == 0 && i != 0 {
                        if !group_has_space {
                                points -= 20; println!("- 20 (no space in group)");
                        }
                        group_has_space = false;
                }
        }

        // Check B: Trigram
        points += trigram_counter * 3; println!("+ {} (trigram)", trigram_counter * 3);

        // Check F: Run-on Sentence Check
        // -150 IF the letter length > 75 characters AND no punctuation in the letter
        if len > 75 && !is_have_punc {
                points -= 150; println!("- 150 (run-on)");
        }
                
        // Check E: Space Ratio Check
        // -20 IF all character in the letter is whitespace
        if is_all_ws {
                points -= 20;
                println!("- 20 (all space)");
        } else {
                // +20 IF ((WHITESPACE_COUNT * 100) / NON_WHITESPACE_COUNT) < 20 ELSE -20
                if (ws_count * 100) / non_ws_count < 20 {
                        points += 20; println!("+ 20 (space ratio check)");
                } else {
                        points -= 20; println!("- 20 (space ratio check)");
                };
        }

        println!("Score: {}", points);
        //  1240 A..B..C..D..E..F..G..H..I..J..K .L..M..N..O..P..Q..R..S..T..U. V..W..X..Y..Z..A..B..C..D..E..F. G..H..I..J..K..L..M..N..O..P..Q .R..S..T..U..V..W..X..Y..Z..A. B..C..D..E..F..G..H..I..J..K L.
        //  1210 A..B..C..D..E..F..G..H..I..J..K..L..M..N..O..P..Q..R..S..T..U..V..W..X..Y..Z..A..B..C..D..E.. F..G..H..I..J..K..L..M..N..O..P..Q..R..S..T..U..V..W..X..Y..Z..A..B..C..D..E..F..G..H..I..J.. K.
        //  1300 A!?.B!?.C!?.D!?.E!?.F!?.G!?.H!?.I!?.J!?.K!?.L!?.M!?.N!?.O!?. P!?.Q!?.R!?.S!?.T!?.U!?.V!?.W!?.X!?.Y!?.Z!?.A!?.B!?.C!?.D!?. E!?.F!?.G!?.H!?.I!?.J!?.K!?.L!?.M!?.N!?.O!?.P!?.Q!?.R!?.S!?. T!?.U!?
        // -1000 A!!!B!!!C!!!D!!!E!!!F!!!G!!!H!!!I!!!J!!!K!!!L!!!M!!!N!!!O!!! P!!!Q!!!R!!!S!!!T!!!U!!!V!!!W!!!X!!!Y!!!Z!!!A!!!B!!!C!!!D!!! E!!!F!!!G!!!H!!!I!!!J!!!K!!!L!!!M!!!N!!!O!!!P!!!Q!!!R!!!S!!! T!!!U!!

        // FINALLY: good response IF total points >= 100 ELSE (bad response IF total points < 50)
        if points >= MAX_POSSIBLE_SCORE {
                println!("You win!");
        } else {
                println!("Not good enough!")
        }
}
