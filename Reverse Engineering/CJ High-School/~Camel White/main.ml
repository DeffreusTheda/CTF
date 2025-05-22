let rec f n = if n <= 1 then n else f (n - 1) + f (n - 2)
let x n = (f n) lxor (n * n)

let () =
  Printf.printf "CJ{";
  let data = [13; 37; 69; 420; 666; 1337] in
  (* let data = [13] in *)
  let rec display item = match item with
    | [] -> Printf.printf "}\n"
    | hd :: tl -> Printf.printf "%x" (x hd); display tl
  in
    display data