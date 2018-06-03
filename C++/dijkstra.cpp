#include<stdio.h>
#include<string.h>
#include<stack>
using namespace std;
const int N=100;
const int INF=100000;
int p[N][N],d[N],path[N];       //path数组用于记录路径

void dijkstra(int sec,int n)    //sec为出发节点，n表示图中节点总数
{
    int i,j,min,min_num;
    int vis[N]={0,};
    for(i=0;i<n;i++)
    {
        d[i]=p[sec][i];
    }
    vis[sec]=1;d[sec]=0;
    for(i=1;i<n;i++)
    {
        min=INF;
        for(j=0;j<n;j++)
        {
            if(!vis[j]&&d[j]<min)
            {
                min=d[j];
                min_num=j;
            }
        }
        vis[min_num]=1;
        for(j=0;j<n;j++)
        {
            if(d[j]>min+p[min_num][j])
            {
                path[j]=min_num;//path[j]记录d[j]暂时最短路径的最后一个中途节点min_num，表明d[j]最后一段从节点min_num到节点j
                d[j]=min+p[min_num][j];
            }
        }
    }
}
void print(int sec,int n)       //sec为出发节点，n表示图中节点总数
{
    int i,j;
    stack<int> q;               //由于记录的中途节点是倒序的，所以使用栈（先进后出），获得正序
    for(i=1;i<n;i++)            //打印从出发节点到各节点的最短距离和经过的路径
    {
        j=i;
        while(path[j]!=-1)      //如果j有中途节点
        {
            q.push(j);          //将j压入堆
            j=path[j];          //将j的前个中途节点赋给j
        }
        q.push(j);
        printf("%d=>%d, length:%d, path: %d ",sec,i,d[i],sec);
        while(!q.empty())       //先进后出,获得正序
        {
            printf("%d ",q.top());//打印堆的头节点
            q.pop();            //将堆的头节点弹出
        }
        printf("\n");
    }
}
int main()
{
    memset(path,-1,sizeof(path));//将path数组初始化为-1
    int i,j,n=6;
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
        {
            p[i][j]=(i==j?0:INF);
        }
    }
    p[0][1]=10;p[0][3]=30;p[1][2]=50;p[1][4]=100;p[2][4]=5;p[3][2]=20;p[3][4]=60;p[4][5]=10;//p[i][j]表示节点i到节点j的距离
    dijkstra(0,n);               //求从节点0出发到各节点的最短距离
    print(0,n);                  //打印从节点0出发到各节点的最短距离和路径
    return 0;
}