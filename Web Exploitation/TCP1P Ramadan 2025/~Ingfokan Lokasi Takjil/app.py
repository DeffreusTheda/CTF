from flask import Flask, render_template, redirect, url_for, request
from pymongo import MongoClient
from bson.objectid import ObjectId
import json
import os

client = MongoClient(os.environ.get('MONGODB_URI'))
# client = MongoClient("mongodb://localhost:27017")
db = client['database']
post_collection = db["posts"]
config = db["config"]
# check if the program has already been setup
is_installed = config.find_one({"installed": True})
if is_installed is None:
    # if not, run setup.py
    os.system("python setup.py")

app = Flask(__name__)

@app.route('/')
def main():
    # grab all posts and only show their id, title, and author
    posts = db["posts"].find({})
    posts_data = list()
    for post in posts:
        posts_data.append([str(post['_id']), post["title"], post["author"]])
    print(posts_data)
    return render_template("index.html", postdata=posts_data)


@app.route('/post/<id>', methods=['GET', 'POST'])
def post(id):

    post = db["posts"].find_one({"_id": ObjectId(id)})
    page = render_template(
        "lokasi.html",
        title=post["title"],
        author=post["author"],
        note=post["note"],
        location=post["location"]
    )

    if request.method == "POST":
        password = request.form['password']

        # ini tadi buat apa yah? -Max
        if password.startswith("{") and password.endswith("}"):
            password = json.loads(password)
        
        posts = db["posts"].find_one({
            "_id": ObjectId(id),
            "password": password
        })
        if posts:
            return page
        else:
            return render_template("password.html", message="Incorrect password")
    
    if post["password"]: return render_template("password.html")

    return page

# favicon
@app.route('/favicon.ico')
def favicon():
    return redirect(url_for('static', filename='favicon.ico'))

    
# make a default for unknown pages 404
@app.errorhandler(404)
def page_not_found(e):
    return render_template("error.html", errorcode=404, errormessage="Page not found")


# make a default for 500 internal server error
@app.errorhandler(500)
def internal_server_error(e):
    return render_template("error.html", errorcode=500, errormessage="Internal server error")


if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000)