module test;

  /* Make a reset that pulses once. */
  reg reset = 0;
  initial begin
     # 17 reset = 1;
     # 11 reset = 0;
     # 29 reset = 1;
     # 11 reset = 0;
     # 250 $stop;
  end
  reg [24*8-1:0] flag = "shc2024{this_is_wrooong}";

  /* Make a regular pulsing clock. */
  reg clk = 0;
  always #5 clk = !clk;

  wire [7:0] e1_value_out;
  wire [7:0] v1_value_out;
  wire [7:0] key;
  wire res = v1_value_out;

  keygen k1 (key, clk, reset);
  encoder e1 (e1_value_out, flag, clk, reset, key);
  validator v1 (v1_value_out, e1_value_out, clk, reset);

  initial begin
     $monitor("Flag checking result is currently %1b !!! %b", res, e1_value_out);
  end
endmodule // test
