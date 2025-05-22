const anchor = require("@coral-xyz/anchor");
const { Keypair, Connection, PublicKey } = require("@solana/web3.js");

const RPC_URL = "http://playground.tcp1p.team:7752/ba6f0c34-7c43-4444-87ce-d602c7bd2340";
const PROGRAM_ID = new PublicKey("5MmByJEupv88VnuvJaf6JhqwvhUZMWrW1de6Y6tViVPe");
const solvedAccount = Keypair.generate();

const provider = new anchor.AnchorProvider(new Connection(RPC_URL), new anchor.Wallet(solvedAccount), {});
anchor.setProvider(provider);
const program = new anchor.Program(require("../target/idl/setup.json"), PROGRAM_ID, provider);

(async () => {
    const tx = await program.methods.initialize().accounts({
        solvedAccount: solvedAccount.publicKey,
        user: provider.wallet.publicKey,
        systemProgram: anchor.web3.SystemProgram.programId
    }).signers([solvedAccount]).rpc();
    console.log("Initialized:", tx);
})();

(async () => {
    const tx = await program.methods.solve().accounts({
        solvedAccount: solvedAccount.publicKey
    }).rpc();
    console.log("Solved:", tx);
})();

(async () => {
    const solved = await program.methods.isSolved().accounts({
        solvedAccount: solvedAccount.publicKey
    }).view();
    console.log("Solved State:", solved);
})();

