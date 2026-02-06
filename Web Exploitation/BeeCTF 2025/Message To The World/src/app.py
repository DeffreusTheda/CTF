from flask import Flask, request, render_template_string
app = Flask(__name__)

BANNED = ["{{", "}}", "os", "system", "class", "popen", "subprocess", "import", "request", "self", "config", "env", "eval", "exec", "locals", "{%", "%}"]  

@app.route("/", methods=["GET", "POST"])
def index():
    if request.method == "POST":
        author = request.form.get("author", "")
        message = request.form.get("message", "")

        counter = 0
        for token in BANNED:
            if token in author:
                counter += 1

        if counter >= 2:
            return "Error: looks like SSTI attempt at author!", 400
        
        counter = 0

        for token in BANNED:
            if token in message:
                counter += 1
        if counter >= 2:
            return "Error: looks like SSTI attempt at message!", 400

        tpl = "<h2>Message to the world from, "+ author + " " + message + "<h2>"
        return render_template_string(tpl)

    return """
    <h3>Message Board</h3>
    <p>Share your message to the world</p>
    <form method="post">
      <label>Author</label><br/>
      <input name="author" /><br/><br/>
      <label>Message</label><br/>
      <input name="message" /><br/><br/>
      <button type="submit">Send</button>
    </form>
    """

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
