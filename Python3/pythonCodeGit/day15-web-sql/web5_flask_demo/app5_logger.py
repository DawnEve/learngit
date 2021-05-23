# 日志功能

from flask import Flask
from flask import request

#Flask通过Python的装饰器在内部自动地把URL和函数给关联起来
#装饰器见day4

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def home():
    return '<h1>logger demo</h1>'

# test logger
@app.route('/logger', methods=['GET', 'POST'])
def test_logger():
    # production 和  development 两种模式都显示的
    app.logger.critical('critical: An critical occurred')
    app.logger.error('error: An error occurred')
    app.logger.warning('warning: A warning occurred (%d apples)', 42)
    # development 才显示的
    app.logger.info('info: A value for info')
    app.logger.debug('debug: A value for debugging')
    return str(app.logger.level)


# 如果不设置下面这一段，只输出到命令行。
# 怎么输出到文件呢？添加下面7行。
import logging,os
formatter=logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
from logging.handlers import TimedRotatingFileHandler
#handler=TimedRotatingFileHandler(**app.config['LOG_PARAMETERS'])
handler=TimedRotatingFileHandler(filename=os.path.join('backup','xxx2020.log.txt'), 
                                 backupCount=31, #最多31个文件，则一个月一个循环。
                                 when='midnight') #每天晚上半夜开一个新文件。会覆盖之前的
handler.setLevel(app.logger.level)
handler.setFormatter(formatter)
app.logger.addHandler(handler)





if __name__ == '__main__':
    app.run(debug=True)