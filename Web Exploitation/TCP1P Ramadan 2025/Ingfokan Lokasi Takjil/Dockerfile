FROM python:3.10

RUN pip install --upgrade pip

WORKDIR /app

COPY . /app

EXPOSE 5000

RUN pip install -r requirements.txt

CMD [ "python", "app.py" ]