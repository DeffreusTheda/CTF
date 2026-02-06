from flask import Flask, request, render_template_string, render_template
import weather

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    districts = [
        "Night City Center",
        "Watson",
        "Westbrook",
        "Heywood",
        "Pacifica",
        "Santo Domingo",
        "City Center",
        "The Glen",
        "Vista Del Rey",
        "Coastview",
        "Arroyo",
        "Rancho Coronado",
        "Wellsprings",
        "Northside",
        "Japantown",
        "Charter Hill",
        "Kabuki",
        "Little China"
    ]
    message = None
    if request.method == 'POST':
        district = request.form.get('district')

        if district in districts:
            data = weather.get_weather(district)
            message = render_template_string(f"Current weather in {district} (on {data['time']}): {data['temperature']}°C, {data['conditions']}")
        else: 
            message = render_template_string(f"District {district} not found.")
    
    return render_template('index.html', districts=districts, message=message)

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=80)
