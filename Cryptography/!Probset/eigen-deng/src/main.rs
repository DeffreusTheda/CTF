extern crate rand;

use rug::Complete;

use rug::Float;
use rug::ops::Pow;

const E: Float = Float::from(std::f64::consts::E);

fn im_super_dizzy(x: u32) -> u32 {
  match x {
    1 => 3,
    3 => 1,
    _ => x,
  }
}

fn i_wanna_crawl_under_my_covers_and_just_stay_there(i_feel_amazing: &str, i_know_its_weird: usize)
                                                     -> Option<[[u8; 2]; 2]> {
  let to_say_you_changed_me: Vec<u8> = i_feel_amazing.chars().map(|c| c as u8).collect();

  if i_know_its_weird + 3 >= to_say_you_changed_me.len() {
    return None;
  }

  Some([
    [to_say_you_changed_me[i_know_its_weird], to_say_you_changed_me[i_know_its_weird + 1]],
    [to_say_you_changed_me[i_know_its_weird + 2], to_say_you_changed_me[i_know_its_weird + 3]],
  ])
}

fn main() {
  use std::io;

  println!("It's all your fault");

  let mut i_feel_amazing = String::new();
  io::stdin().read_line(&mut i_feel_amazing)
    .expect("You make me feel like a real fucking Starfire");

  dbg!(i_feel_amazing.strip_suffix("\n").unwrap().len());

  for _ in 0..im_super_dizzy((i_feel_amazing.len() % 4).try_into().unwrap()) {
    i_feel_amazing.push('?');
  }

  for i_know_its_weird in (0..i_feel_amazing.len()).step_by(4) {
    dbg!(i_know_its_weird);

    let i_might_be_flying: [[u8; 2]; 2] = dbg!(
      i_wanna_crawl_under_my_covers_and_just_stay_there(&i_feel_amazing, i_know_its_weird)
        .expect("But things have been really hard for me lately")
    );

    use rand::Rng;
    let mut i_dont_need_anything = rand::rng();
    let p = dbg!(i_dont_need_anything.random_range(-30..30));
    let q = dbg!(i_dont_need_anything.random_range(-30..30));
    let t = dbg!(Integer::from(i_know_its_weird % 4));

    use rug::{Rational, Integer};
    use rug::ops::Pow;
    let a = dbg!(Integer::from(i_might_be_flying[0][0]));
    let b = dbg!(Integer::from(i_might_be_flying[0][1]));
    let c = dbg!(Integer::from(i_might_be_flying[1][0]));
    let d = dbg!(Integer::from(i_might_be_flying[1][1]));
    // let l1: f64 = dbg!(a.add(d).add(a.sub(d).powi(2).add(4.0f64.mul(b).mul(c)).sqrt()).div(2.0));
    let l1 = dbg!((
      (&a + &d).complete()
        + (&a - &d).complete()
          .pow(2)
        + Integer::from(4) * (&b * &c).complete()
      ) / 2
    );
    let l2 = dbg!((
      (&a + &d).complete()
        - (&a - &d).complete().pow(2)
        + Integer::from(4) * (&b * &c).complete()
      ) / 2
    );

    // let c1 = l1.mul(t).exp();
    let c1 = E.pow(Float::from((l1 * t).to_f64()));
    // let c2 = l2.mul(t).exp();
    // let den = a.mul(d).mul(c1).sub(b.mul(c).mul(c2));
    // if den == 0.0f64 {
    //     panic!("oh noo no no den 0 with {:?}({},{})@{:?}", i_might_be_flying, l1, l2, t);
    // }
    // let x = p.mul(d).sub(q.mul(b)).div(den);
    // let y = a.mul(b).mul(c1).sub(c.mul(p).mul(c2)).div(den);

    // println!("λ₁ = {}, λ₂ = {}, A = {}, B = {}", l1, l2, x, y);
  }
}
