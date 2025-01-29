The challenge is about matrix multiplication optimization.
I guess most people are tricked by the machine learning disguise here, hehe.
Investigating the algorithm, it's far different from your normal naive matrix multiplication algorithm,
but the result is the same for the attentive and dynamic tester.
Well, doing dynamic would be too easy so I'll just compile this in a format that most can't run.
Though, if you follow through the logic of fetchPretrainedWeights something function, you'll find that the argument URL string is xored into something else entirely:
fetchPretrainedWeights("https://huggingface.co/madebyollin/taesd/resolve/main/taesd_encoder.safetensors", "./.466.m"); // -> `https://github.com/mkauers/matrix-multiplication/raw/refs/heads/main/466/k14ab186def1b9333.exp`
fetchPretrainedWeights("https://huggingface.co/madebyollin/taesd/resolve/main/taesd_decoder.safetensors", "./.467.m");   // -> `https://github.com/mkauers/matrix-multiplication/raw/refs/heads/main/467/k049c136198369dc.exp`
fetchPretrainedWeights("https://huggingface.co/pbxadb/sdxl-models/resolve/main/wildcardxXLFusion_fusion.safetensors", "./.667.m"); // -> `https://github.com/mkauers/matrix-multiplication/raw/refs/heads/main/667/k1b9c131fc81094d0.exp`
Among other facts about how the algorithm works, you can discard your initial hypothesis that this is a machine learning program, and reason that this is in fact, just a matrix multipliction program disguised as such.
There are over 400+ different rank of multiplications, each turned into a lambda function,
and the result is around 150000+ identifiable functions in the binary.
so statically reversing the *optimized* algorithm is... an inhuman feat.
Solution concept (also see solver for implementation):

First, do a static analysis of the matrices and the equations, like this:

Let:
- Unknown (input split into):
  - A (4×6)
  - B (6×6)
  - C (6×7)
- Known from `output.txt`, group of characters delimited by space:
  - D (4x6)
  - E (4x7)
  - F (6x7)
  - H (4x7)
  - G (6x7)
- Analyzed Equations (from algo analysis):
  - AB = D (4×6)
  - BC = E (6×7)
  - AC = F (4×7)
  - AG = H (4×7)

Solution Steps:
- A = HG⁺ where G⁺ is pseudoinverse of G
  - This is easily reversible with numpy
- B = A⁺D where A⁺ is pseudoinverse of A
  - This fails for some reason
  - Therefore at this stage, we only have A
- Use Z3 to solve this with naive multiplication (or optimized if you wanna, i'm not stopping you)
  - Faster when we have A known
  - Around 5 minutes on my old mac M1 Air

see deepseek (the chinese ai—ironic) fails at this challenge: https://chat.deepseek.com/a/chat/s/d8372188-1fb6-457f-9aa7-a4061e07455d