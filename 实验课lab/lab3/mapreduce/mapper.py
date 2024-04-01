import sys
import time
time_start = time.time() # start

for each_line in sys.stdin: #stream data
    each_line = each_line.strip() #stripping
    words = each_line.split() #stripping
    for word in words:
        print("%s\t%s" % (word, 1)) # mapper

time_end = time.time() #end
time_c= time_end - time_start # get time
print('mapper time cost', time_c, 's') # delete it when reducing

