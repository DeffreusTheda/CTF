fn main(){macro_rules!    s{()=>{"fn main(){{macro_rules!    s{{()=>{{{:?}}}}};print!(s!(),s!());}}//999999999943CF=16dist=0"}};print!(s!(),s!());}//999999999943CF=16dist=0

fn main(){let R=11*9;macro_rules! s{()=>{"fn main(){{let R=11*9;macro_rules! s{{()=>{{{:?}}}}};print!(s!(),s!());println!("{{}}",R);}}"}};print!(s!(),s!());println!("{}",R);}
                     /////////

fn main(){let t=("fn main(){let t=", ";print!(\"{}{:?}{}\",t.0,t,t.1)}//99999");print!("{}{:?}{}",t.0,t,t.1)}//99999

fn main(){let x=7*11;let t=("fn main(){let x=7*11;let t=(", ";print!(\"{}{:?}{}={}\",t.0,t,t.1,x)}");print!("{}{:?}{}={}",t.0,t,t.1,x)}

`fn main(){let t=("fn main(){let t=", ";print!(\"{}{:?}{}\",t.0,t,t.1)}//99999");print!("{}{:?}{}",t.0,t,t.1)}//99999`
Modify this quine so that the sum of all digit characters in the source code IS ODD. When you change the comment on the template, the one on the source code must change too. This means any digit in template have its digit in the source code, leading to all digit being doubled, therefore, even sum. Any idea?

fn main(){let t=("fn main(){let t=", ";print!(\"{}{:?}{}//1\",t.0,t,t.1)}//99999CF=16dist=00000000999994");print!("{}{:?}{}//1",t.0,t,t.1)}//99999CF=16dist=00000000999994//1
