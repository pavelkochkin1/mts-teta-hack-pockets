import string
import json
import joblib
import sys
from nltk.stem import SnowballStemmer

def tokenize(host: str):
    '''Tokenizer for string with host'''

    tokens = host.split(sep='.')
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
    proba = model.predict_proba(host)[0,1]

    if prediction == [1]:
        result = json.dumps({"class": 'human', "proba": proba})
    else:
        result = json.dumps({"class": 'tech', "proba": proba})
    print(result)

if __name__ == "__main__":
    main()