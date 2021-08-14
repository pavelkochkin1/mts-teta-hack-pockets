import string
import json
import joblib
import sys
from nltk.stem import SnowballStemmer


def tokenize(url: str):
    tokens = url.split(sep='.')
    tokens = [i for i in tokens if i not in string.punctuation]
    tokens = [snowball.stem(i) for i in tokens]
    return tokens

snowball = SnowballStemmer(language='english')

def main():
    try:
        model = joblib.load('basemodel.joblib')
    except:
        sys.stdout('ERROR: downloading model')

    host = [sys.argv[1]]
    prediction = model.predict(host).tolist()

    if prediction == [1]:
        result = json.dumps({"class": 'human'})
    else:
        result = json.dumps({"class": 'tech'})
    print(result)

if __name__ == "__main__":
    main()