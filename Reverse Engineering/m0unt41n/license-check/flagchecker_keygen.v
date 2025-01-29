module keygen(key, clk, reset);

  parameter WIDTH = 8;
  parameter WLDTH = 2;

  output [WIDTH-1 : 0] key;
  input                clk, reset;

  reg [WIDTH-1 : 0]   part;
  reg [WLDTH-1 : 0]   cnt;
  reg [WIDTH-1 : 0]   key;
  wire               clk, reset;


  always @(negedge clk or posedge reset) begin
    if (reset) begin
      cnt <= 0;
      key <= 8'b11011001;
    end else begin
      key <= key + 2*cnt;
      cnt <= cnt +1;
    end
   end
endmodule

