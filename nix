{ pkgs ? import <nixpkgs> {}}:

let
  riscvPkgs =
    import <nixpkgs> {
      # uses GCC and newlib
      crossSystem = { system = "riscv64-none-elf"; };
    };
in

riscvPkgs.mkShell {

  packages = [
    pkgs.hello
    pkgs.antlr4_12
    pkgs.python312
    pkgs.pyright
    pkgs.python312Packages.pytest
    pkgs.python312Packages.pytest-xdist
    pkgs.python312Packages.pytest-cov
    pkgs.python312Packages.antlr4-python3-runtime 
    pkgs.graphviz
    pkgs.spike
    pkgs.dtc
    pkgs.pkgsCross.riscv64.riscv-pk
  ];
}