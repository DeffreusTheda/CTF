import random
from datetime import datetime

def get_weather(district_name):
    weather_conditions = {
        "Sunny (clear)": ['20C', '25C', '30C', '35C'],
        "Light clouds": ['15C', '20C', '25C'],
        "Cloudy": ['10C', '15C', '20C'],
        "Heavy clouds": ['10C', '15C', '20C'],
        "Fog": ['10C', '15C'],
        "Pollution": ['25C', '30C', '35C'],
        "Rain": ['15C', '18C', '20C'],
        "Toxic rain": ['15C', '18C', '20C'],
        "Sandstorm": ['35C', '40C', '45C', '50C'],
        "Deep blue (clear with blue tint)": ['20C', '25C'],
        "Cloudy morning (dense clouds, but no fog)": ['15C', '20C'],
        "Courier clouds (dense blue clouds and fog)": ['15C', '20C'],
        "Light rain": ['18C', '20C', '22C'],
        "Rainy night (rainy, but not cloudy)": ['10C', '12C', '15C'],
        "Squat morning (rain, but not blue)": ['18C', '20C', '22C']
    }

    # Select a random weather condition from the list.
    current_conditions = random.choice(list(weather_conditions.keys()))

    # Select a random temperature from the list of that weather condition.
    current_temperature = random.choice(weather_conditions[current_conditions])

    # Get the current date and modify the year to 2077.
    now = datetime.now()
    reported_time = now.replace(year=2077).strftime("%B %d %Y, %H:%M")

    return {
        'time': reported_time,
        'temperature': current_temperature,
        'conditions': current_conditions
    }
