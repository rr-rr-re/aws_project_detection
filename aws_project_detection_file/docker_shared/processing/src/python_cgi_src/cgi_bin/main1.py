# coding: utf-8
from http.server import BaseHTTPRequestHandler, HTTPServer,\
SimpleHTTPRequestHandler
from urllib.parse import parse_qs, urlparse

import run_detection
#/Users/ruimac/python_http_server/python_http_server_file/docker_shared/processing/src/run_detection.py


# ハンドラを定義していく
class MyHTTPRequestHandler(BaseHTTPRequestHandler):

    def do_GET(self):
        parsed_path = urlparse.urlparse(self.path)
        print(parsed_path)

        # 成功レスポンス(200)を返す
        if parsed_path.path == "/ok-api":
            self.send_response(200)
            run_detection()
            self.end_headers()
            self.wfile.write("OK")
            return

        # 失敗レスポンス(403)を返す
        elif parsed_path.path == "/ng-api":
            self.send_error(403, "NG!")
            self.end_headers()
            return

if __name__ == "__main__":
    address = ('localhost', 5000)

    server = HTTPServer(address, MyHTTPRequestHandler)#サーバインスタンスを生成
    server.serve_forever()#常時受けつけモードを指定。
