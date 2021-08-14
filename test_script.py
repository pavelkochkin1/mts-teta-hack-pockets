import random 
import json

res_list = ['human', 'tech']

def main():
    res_int = random.randint(0,1)
    result = json.dumps([{"class": res_list[res_int]}])
    print(result)

if __name__ == "__main__":
    main()