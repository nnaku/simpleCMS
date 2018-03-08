// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import moment from 'vue-moment'

Vue.use(VueAxios,axios.create({
  baseURL: 'http://localhost:8080/api/',
  headers: {
    'Access-Control-Allow-Origin': 'http://localhost:8081/api'
  }
}))

Vue.use(moment)
Vue.config.productionTip = true

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
