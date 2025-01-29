module encoder(out, in, clk, reset, key);

  parameter WIDTH = 8;
  parameter WLDTH = 2;

  output [WIDTH-1 : 0] out;
  input [WIDTH-1 : 0] key;
  input [(24*WIDTH)-1 : 0]  in;
  input                clk, reset;

  reg [WIDTH-1 : 0]   out;
  reg [WIDTH-1 : 0]   part;
  reg [WIDTH-1 : 0]   cnt;
  wire               clk, reset;


  always @(posedge clk or posedge reset) begin
    if (reset) begin
      out <= 0;
      part <= 0;
      cnt <= 0;
    end else begin
      if (part == 3) begin
        part <= 0;
      end else begin
        part <= part + 1;
      end
      cnt <= cnt +1;
      out <= key ^ (in & {WIDTH{1'b1}} << (cnt * WIDTH)) >> (cnt * WIDTH);
    end
   end
endmodule
