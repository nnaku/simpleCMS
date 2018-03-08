import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Articles from '@/components/Articles'
import Article from '@/components/Article'
import NewArticle from '@/components/NewArticle'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/articles',
      name: 'articles',
      component: Articles
    },
    {
      path: '/article/:articleId',
      name: 'article',
      component: Article
    },
    {
      path: '/new-article',
      name: 'newArticle',
      component: NewArticle
    }
  ]
})
