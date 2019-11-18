import sys

def func(a,b):
    return (a+b)

if __name__ == '__main__':
    a = []
    #sys.argv用于获取参数url1，url2等。而sys.argv[0]代表python程序名，所以列表从1开始读取参数。
    for i in range(1, len(sys.argv)):
        a.append((int(sys.argv[i])))

    print(func(a[0],a[1]))
