// const scriptPath = new URL(Deno.mainModule).pathname;
// const scriptContent = await Deno.readTextFile(scriptPath);
// const messageBuffer = new TextEncoder().encode(scriptContent);
// const hashBuffer = await crypto.subtle.digest('SHA-256', messageBuffer);
// import { encodeHex } from 'jsr:@std/encoding/hex';
// const currentHash = encodeHex(hashBuffer);
// if (!(currentHash === "7f71ced2313502a83ed63cc8ebe4509069fa9f518adab4330fd7113e8c8ed50a" || currentHash === "d0ff7a89b7bc6bc035ca988687499f5c31daa826e431b2eff8ee15f0ff9811cc")) {
  // console.error("Integrity check failed! The script has been modified.");
  // Deno.exit(0x1);
// }
// function getRandomInt(max) {
  // return Math.floor(Math.random() * max);
// }
// export function onid(a, b) {
  // return a.map((v, i) => v ^ b[i % b.length]);
// }
function a(arg) {
  let name = '';
  const chars = arg.split('-').map(c => String.fromCharCode(parseInt(c, 0x10)));
  let strin = chars.join('');
  for (let i = 0x0; i < strin.length; i++) {
    let sc = strin.charAt(i);
    let rand = Math.floor(Math.random() * 26) + 65;
    name += String.fromCharCode((sc.charCodeAt(0x0) - rand + 0x100) % 0x100);
  }
  return name;
}
console.log(a("98-b9-d2-be-bd-b7-bb-c7-a0-b7-ba-be-ae-c9"));
