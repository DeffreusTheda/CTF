const seedrandom = require('seedrandom'); // External library for deterministic PRNG

function predict(arg, seed) {
  let rng = seedrandom(seed); // Initialize PRNG with a known seed
  let name = '';
  const chars = arg.split('-').map(c => String.fromCharCode(parseInt(c, 16)));
  let strin = chars.join('');

  for (let i = 0; i < strin.length; i++) {
    let sc = strin.charAt(i);
    let rand = Math.floor(rng() * 26) + 65; // Predictable random number
    name += String.fromCharCode((sc.charCodeAt(0) - rand + 256) % 256);
  }
  return name;
}

// Example usage
let seed = "example_seed"; // Guess seed
let arg = "98-b9-d2-be-bd-b7-bb-c7-a0-b7-ba-be-ae-c9";
console.log(predict(arg, seed));
