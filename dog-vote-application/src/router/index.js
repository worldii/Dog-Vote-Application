import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    redirect: "/list",
    component: () => import("@/views/DogListView.vue"),
    children: [
      {
        path: "list",
        name: "dogList",
        component: () => import("@/components/dogs/DogList.vue"),
      },
      {
        path: "view/:id",
        name: "dogsView",
        component: () => import("@/components/dogs/DogView.vue"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
