let fib n =
  let rec aux a b i =
    if i = n then a
    else aux b (a + b) (i + 1)
  in aux 0 1 0

let x n = (fib n) lxor (n * n)

let () =
  Printf.printf "CJ{";
  let data = [13; 37; 69; 420; 666; 1337] in
  let rec display = function
    | [] -> Printf.printf "}\n"
    | [last] -> Printf.printf "%x}\n" (x last)
    | hd :: tl -> Printf.printf "%x" (x hd); display tl
  in display data

