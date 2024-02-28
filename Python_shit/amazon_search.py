import webbrowser 

browser_path= 'C:/Programmi/Google/Chrome/Application/chrome.exe %s'

search = input("your amazon search request here ")

webbrowser.register('chrome', None, webbrowser.BackgroundBrowser(browser_path))

print("which criteria you would like to use for your search ")
sorting=input("1 - price (lowest to highest), 2 - price (lowest to highest), 3 - rewiew rank (highest to lowest), 4 - the newest ones ")
if sorting==1:
    base_url="http://www.amazon.com/s?k="+search+"&sprice-asc-rank&crid=X0Y5VVMPHZH1&qid=1708515745&sprefix=%2Caps%2C72&ref=sr_st_price-asc-rank&ds=v1%3A2EXrQ7nuEha6SzKoFr4%2B2YgBhlQBRTSbAapFdttgJe8"
    webbrowser.open(base_url)
elif sorting==2:
    base_url="http://www.amazon.com/s?k="+search+"&sprice-desc-rank&crid=X0Y5VVMPHZH1&qid=1708515936&sprefix=%2Caps%2C72&ref=sr_st_price-desc-rank&ds=v1%3AUOehBt%2BZec5fiJhCZ8DWIlNx2H0KGRP5WQhcEDmJA7Y"
    webbrowser.open(base_url)
elif sorting==3:
    base_url="http://www.amazon.com/s?k="+search+"&sreview-rank&crid=X0Y5VVMPHZH1&qid=1708515938&sprefix=%2Caps%2C72&ref=sr_st_review-rank&ds=v1%3A5UuRjayJl8l%2BvjLeXJ4penKW0AFChxh4ehunB6wz0LY"
    webbrowser.open(base_url)
elif sorting==4:
    base_url="http://www.amazon.com/s?k="+search+"&s=date-desc-rank&crid=X0Y5VVMPHZH1&qid=1708515987&sprefix=%2Caps%2C72&ref=sr_st_date-desc-rank&ds=v1%3AwjaLMeO8ebh3cyq3iHrpCdEdtEUQCisoge7iB7RlI%2FE"
    webbrowser.open(base_url)