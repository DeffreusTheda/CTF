module validator(out, in, clk, reset);

  parameter WIDTH = 8;

  output [WIDTH-1 : 0] out;
  input [WIDTH-1 : 0]  in;
  input                clk, reset;

  reg [WIDTH-1 : 0]   out;
  reg [WIDTH-1 : 0]   flagpart;
  reg [WIDTH-1 : 0]   flagin;
  reg [WIDTH-1 : 0]   part;
  reg [WIDTH-1 : 0]   cnt;
  reg [WIDTH-1 : 0]   key;
  wire               clk, reset;

  reg [25*8-1:0] flag = 200'h52737427253d3f7279669699ccb29a96998481808ce7b8a400;


  always @(posedge clk or posedge reset) begin
    if (reset) begin
      out <= 1;
      cnt <= 0;
      flagpart <= 0;
      flagin <= 0;
    end else begin
      flagin <= in;
      flagpart <= (flag & {WIDTH{1'b1}} << (cnt * WIDTH)) >> (cnt * WIDTH);
      if (in == (flag & {WIDTH{1'b1}} << (cnt * WIDTH)) >> (cnt * WIDTH)) begin
        out <= out;
      end else if (in == 8'heb) begin
        out <= out;
      end else begin
        out <= 8'b0;
      end
      cnt <= cnt +1;
    end
   end
endmodule
