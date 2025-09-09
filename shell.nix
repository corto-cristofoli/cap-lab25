{ pkgs ? import <nixpkgs> {}}:

pkgs.pkgsCross.riscv64-embedded.mkShell {
  nativeBuildInputs = with pkgs; [
    hello
    antlr4_12
    (python312.withPackages (ps: with ps; [
      pytest
      pytest-xdist
      pytest-cov
      antlr4-python3-runtime
    ]))
    basedpyright
    graphviz
    spike
    dtc
    pkgsCross.riscv64-embedded.riscv-pk
  ];
}