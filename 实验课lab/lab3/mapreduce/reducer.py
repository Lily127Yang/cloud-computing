import sys
import time
time_start = time.time() # start
mr_dic = {} #init
for each_line in sys.stdin:# stream data
    each_line = each_line.strip()
    word = each_line.split('\t') #seperate word and count
    counting = each_line.split('\t') #seperate word and count


    try: # string -> integer
        counting = int(counting)
    except ValueError:
        continue

    if word in mr_dic:
         mr_dic[word] += 1 #already in dic->++
    else:
        mr_dic.setdefault(word, 1) #new dict

for key, value in mr_dic.items():# print outcome
    print('%s\t%s' % (key, value))

time_end = time.time() #end
time_c= time_end - time_start #cost
print('reduce time cost', time_c, 's')