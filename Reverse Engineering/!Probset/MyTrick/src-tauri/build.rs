fn main() {
  // Tell the build system to disable stripping of debug symbols
  println!("cargo:rustc-env=RUSTFLAGS=-C link-arg=-Wl,--no-strip");
  println!("cargo:rustc-env=RUSTFLAGS=-C debuginfo=2");
  
  // Standard tauri build
  tauri_build::build()
}
