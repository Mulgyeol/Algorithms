def palindrome(s):
    k = len(s)
    if k==1:
        return 'true'
    
    if k == 2:
        if s[0] == s[1]:
            return 'true'
        else:
            return 'false'

    if s[0]==s[k-1]:
        palindrome(s[1:k-1])
	
    else:
        return 'false'

    return 'true'

print(palindrome(input()))
