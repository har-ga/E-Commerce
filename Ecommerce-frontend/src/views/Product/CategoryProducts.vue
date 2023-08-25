<template>
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h4 class="pt-3">Our Products</h4>
          <router-link
            :to="{ name: 'CategoryProduct', params: { categoryName: 'Mobile' } }"
            v-show="$route.name === 'CategoryProduct'"
            >

          </router-link>

        </div>
      </div>
      <div class="row">
          <div v-for="product of products" :key="product.id" class="col-md-6 col-xl-4 col-12 pt-3  justify-content-around d-flex">
            <ProductBox :product="product">
            </ProductBox>
          </div>
      </div>
    </div>
  </template>
  
  <script>
  import ProductBox from '../../components/Product/ProductBox';
  
  export default {
    name: 'CategoryProduct',
    components: { ProductBox },
    data() {
      return {
        products: [],
        categoryName: this.$route.params.categoryName // Get the category name from the URL
      };
    },
    mounted() {
      this.fetchProductsByCategory();
    },
    methods: {
      async fetchProductsByCategory() {
        try {
          const response = await fetch(`/api/productByCategory?category=${this.categoryName}`);
          const data = await response.json();
          this.products = data;
        }
        catch (error) {
          console.error('Error fetching products:', error);
        }
        }
      }
    };
  </script>
  

  <style scoped>
  
  .card{
    width : 20rem;
    height : 24rem;
  }
  
  h4 {
    font-family: 'Roboto', sans-serif;
    color: #484848;
    font-weight: 700;
  }
  
  #add-product {
    float: right;
    font-weight: 500;
  }
  </style>
  