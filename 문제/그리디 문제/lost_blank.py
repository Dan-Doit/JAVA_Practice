import re

text = input()
text = text + '+0'
if text[0] == '-':
    text = '0' + text
    nums = list(map(int,re.split('-|\+',text)))
else:
    nums = list(map(int,re.split('-|\+',text)))

copy = nums.copy()
print(copy)
plmi = ['+','-']
count = 0
copy_count = 0
result = 0
for i in text:
    if i in plmi:
        count += 1
        copy_count += 1
        if '-' == i:
            for i in range(count,len(copy)):
                result -= copy[count]
                copy.pop(copy_count)
            break
    else:
        continue

print(sum(copy)+result)



