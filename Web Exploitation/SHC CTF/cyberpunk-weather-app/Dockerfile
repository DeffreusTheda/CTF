FROM python:3.9-alpine
WORKDIR /app
COPY ./app/ .
COPY ./flag.txt /flag.txt
RUN pip install --no-cache-dir -r requirements.txt
EXPOSE 80
CMD ["python", "app.py"]
