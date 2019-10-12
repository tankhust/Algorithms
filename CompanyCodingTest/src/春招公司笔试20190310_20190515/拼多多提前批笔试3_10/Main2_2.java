/*
package tankInternshipInterview.practice.拼多多提前批笔试3_10;

*
 * @author tankInternshipInterview
 * @create 2019/03/10 17:31


public class Main2_2 {
}
#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<algorithm>
#define N 100005
        using namespace std;

        bool f[N][27],vis[27];
        int s[N],first[N],next[N],ans[27];
        char ch[N];

        int main()
        {
        scanf("%s",ch);
        int n=strlen(ch),tot=0;
        for(int i=n;i>=1;i--)
        {
            s[i] = ch.charAt(i) - 'a' + 1;
//        s[i]=ch[i-1]-'a'+1;
        if(!vis[s[i]])
        {
        tot++;
        vis[s[i]]=1;
        }
        }
        memset(vis,0,sizeof(vis));
        f[n][s[n]]=1;
        first[s[n]]=n;
        for(int i=n-1;i>=1;i--)
        {
        for(int j=1;j<=26;j++)
        f[i][j]=f[i+1][j];
        f[i][s[i]]=1;
        next[i]=first[s[i]];
        first[s[i]]=i;
        }
        int now=0;
        for(int i=1;i<=tot;i++)
        for(int j=1;j<=26;j++)
        {
        if(vis[j])continue;
        while(first[j]&&first[j]<=now)first[j]=next[first[j]];
        int sum=0;
        for(int k=1;k<=26;k++)
        if(!vis[k]&&f[first[j]][k])sum++;
        if(sum==tot-i+1)
        {
        ans[i]=j;
        vis[j]=1;
        now=first[j];
        break;
        }
        }
        for(int i=1;i<=tot;i++)
        putchar(ans[i]+'a'-1);
        return 0;
        }

*//*

#include <iostream>
#include <stdlib.h>
        #include <string>
#define max_length 30
        using namespace std;
        int main() {
        string s;
        cin >>s;
        std::transform(s.begin(), s.end(), s.begin(), ::tolower);
        int count[max_length]={0};
        long l = s.size();
        for (int i=0; i<l;i++)
        count[s[i]]++;
        char ans='z';
        for (int i=0; i<l/2; i++){
        if (s[i]<ans) ans=s[i];
        count[s[i]]--;
        if (count[s[i]]==0) break;
        }
        cout<<ans<<endl;
        return 0;
        }
*/
