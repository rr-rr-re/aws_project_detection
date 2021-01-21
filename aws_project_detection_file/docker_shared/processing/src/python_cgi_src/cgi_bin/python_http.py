# coding: utf-8
from http.server import BaseHTTPRequestHandler, HTTPServer,\
SimpleHTTPRequestHandler
#from urllib.parse import parse_qs, urlparse
import urllib.parse as urlparse

#import run_detection
#/Users/ruimac/python_http_server/python_http_server_file/docker_shared/processing/src/run_detection.py

def start(port, callback):
    def handler(*args):
        MyHTTPRequestHandler(callback, *args)
    server = HTTPServer(('', int(port)), handler)
    server.serve_forever()


# ハンドラを定義していく
class MyHTTPRequestHandler(BaseHTTPRequestHandler):
    def __init__(self, callback, *args):
        self.callback = callback
        BaseHTTPRequestHandler.__init__(self, *args)

    def do_GET(self):
        parsed_path = urlparse.urlparse(self.path)

        # 成功レスポンス(200)を返す
        if parsed_path.path == "/ok-api":
            self.send_response(200)
            run_detection()
            self.end_headers()
            self.callback()
            self.wfile.write("OK")
            return

        # 失敗レスポンス(403)を返す
        elif parsed_path.path == "/ng-api":
            self.send_error(403, "NG!")
            self.end_headers()
            return

        # クエリパラメータ("left-str", "right-str")を連結した文字列を返す
        # /concat-str?left-str=Hello&right-str=World
        elif parsed_path.path == "/concat-str":
            # クエリパラメータのパース(dictionary型)
            querys = urlparse.parse_qs(parsed_path.query)
            if ("left-str" in querys) and ("right-str" in querys):
                concat_str = querys["left-str"][0] + querys["right-str"][0]
                self.send_response(200)
                self.end_headers()
                self.wfile.write(concat_str)

            else:
                #"left-str"と"right-str"のクエリがなかったらエラー
                self.send_error(400, "query NG!")
                self.end_headers()
                return

        # Jsonを返す
        elif parsed_path.path == "/return-json":
            data = [{u"name":u"尾崎豊", u"age":26},
                    {u"name":u"hide", u"age":33}]
            jsonData = json.dumps(data, ensure_ascii=False, encoding='utf-8')

            self.send_response(200)
            self.send_header("Content-type", "application/json")
            self.end_headers()

            self.wfile.write(jsonData.encode("utf-8"))
            return

        else:
            self.send_error(400, "NG!")
            self.end_headers()
            return

"""
if __name__ == "__main__":
    address = ('localhost', 5000)

    server = HTTPServer(address, MyHTTPRequestHandler)#サーバインスタンスを生成
    server.serve_forever()#常時受けつけモードを指定。
"""
