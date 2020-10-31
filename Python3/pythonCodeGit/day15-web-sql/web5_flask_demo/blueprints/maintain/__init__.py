#
from flask import Blueprint

bp=Blueprint('maintain', __name__,
             template_folder='templates',
             static_folder='static')

@bp.route('/ping')
def ping():
    return "pong"

# 然后在入口中引入该文件