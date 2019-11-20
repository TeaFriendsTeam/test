from flask import request, Flask, Response
from flask_cors import CORS, cross_origin
import json, random

random.seed()

app = Flask(__name__)
cors = CORS(app, resources={r'/random.*': {'origins': '*'}})
app.config['CORS_HEADERS'] = 'Content-Type'


def resp(status_code, data=None):
    return Response(status=status_code,
                    mimetype='application/json',
                    response=json.dumps(data,
                                        indent=4,
                                        ensure_ascii=False) + "\n")


@app.route('/random', methods=['GET'])
@cross_origin(origin='*')
def get_random_number():
    return resp(200, random.randint(0, 100))
