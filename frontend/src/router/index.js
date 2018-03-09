import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'

import Article from '@/components/Article/Article'
import ArticleList from '@/components/Article/ArticleList'
import ArticleForm from '@/components/Article/ArticleForm'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/article/:articleId',
      name: 'article',
      component: Article
    },
    {
      path: '/articles',
      name: 'article-list',
      component: ArticleList
    },
    {
      path: '/new-article',
      name: 'new-article-form',
      component: ArticleForm
    }
  ]
})
