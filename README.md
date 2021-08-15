# Service for classification host to 'human' or 'tech'.
mts.teta hackathon - Case 3 - Pockets Team

Service Link - http://human-host.ipq.co:8760

Our service can classify hosts according to their purpose.

We will return `tech` if the host is technical
and `human` if the host is for an end user.

## How to run:
1. `pip install -r requirements.txt`
2. `python basemodel.py 'HOST'`

For example: `python basemodel.py 'google.com'`

## Source code
* [data/](data/) - contains all datasets, [notebook](data/data.ipynb) for making data ready 
* [model/](model/) - includes [requirements](model/requirements.txt), [model](model/model.ipynb) and [script](model/basemodel.py)
* [JsonOrHtmlApplication](JsonOrHtmlApplication/) - containt service logic