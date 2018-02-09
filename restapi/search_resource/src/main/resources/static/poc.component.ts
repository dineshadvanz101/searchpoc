const app = new Vue ({
  el: '#app',
  data: {
    isActive: '',
    postList : [],
    categoryList : [],
    category_search: '',
    selected: '',
    title_search: '',
    rest_end_point: 'http://35.188.38.60:9087/search/',
    category_path: '',
    keyword_path : '',
    alphabet : '',
    emptybrands_alphabet : []
  },
  watch:{
    /*Search by category*/
    selected: function(newVal, oldVal){
      this.search_category(newVal);
    },
    /*Search by title*/
    title_search: function(newVal, oldVal){
      this.alphabet = '';
      this.isActive= '';
      if(newVal != '' && this.selected != '' )
        if(this.selected == 'All')
          this.keyword_path = this.rest_end_point+"brands?brand="+encodeURIComponent(newVal);
        else
          this.keyword_path = this.rest_end_point+"brands?brand="+encodeURIComponent(newVal)+"&category="+encodeURIComponent(this.selected);
		else if(newVal == '' )
		{
		  if(this.selected != '' && this.selected == 'All' )
			this.keyword_path = this.rest_end_point+"brands?category=";
		  else
			this.keyword_path = this.rest_end_point+"brands?category="+encodeURIComponent(this.selected);
		}		
		else
          this.keyword_path = this.rest_end_point+"brands?brand="+encodeURIComponent(newVal);
          
      axios.get(this.keyword_path)
      .then(response => {
        this.postList = response.data.data;
        //alert(JSON.stringify(this.postList));
      }).catch( error => { console.log(error); });
    }
  },
  mounted() {
    this.getPosts();
    this.getCategory();
    this.getLetters();
  },
  methods: {
    /*Show default brands list*/
    getPosts() {
      axios.get(this.rest_end_point+"brands"
        )
      .then(response => {
        this.postList = response.data.data;
      }).catch( error => { console.log(error); });
    },
    /*Search by alphabets*/
    search_alphabetically(value,index){
      this.alphabet = value;
      this.title_search='';
      if(value == 'ALL')
        value = '';

      if(value != '' && this.selected != '' )
        if(this.selected == 'All')
          this.keyword_path = this.rest_end_point+"brands?brand="+encodeURIComponent(value);
        else
          this.keyword_path = this.rest_end_point+"brands?brand="+value+"&category="+encodeURIComponent(this.selected);
      else if(value == '' && this.selected != '' )
        if(this.selected == 'All')
          this.keyword_path = this.rest_end_point+"brands?category=";
        else
           this.keyword_path = this.rest_end_point+"brands?category="+encodeURIComponent(this.selected);
      else if(value != '' && this.selected != 'All' )
        this.keyword_path = this.rest_end_point+"brands?brand="+encodeURIComponent(value);
      else
        this.keyword_path = this.rest_end_point+"brands?brand="+encodeURIComponent(value);
      
      axios.get(this.keyword_path)
      .then(response => {
        this.postList = response.data.data;
        this.isActive= index;
      }).catch( error => { console.log(error); });

    },
    /*Search by category*/
    search_category(value){
      if(this.alphabet == 'ALL')
        this.alphabet = '';
      if(value != '' && this.alphabet != ''){
        this.title_search = '';
        if(value == 'All')
          this.category_path = this.rest_end_point+"brands?brand="+encodeURIComponent(this.alphabet);
        else
        this.category_path = this.rest_end_point+"brands?brand="+encodeURIComponent(this.alphabet)+"&category="+encodeURIComponent(value);
      }else if(value != '' && this.title_search != ''){
        this.alphabet = '';
        if(value == 'All')
          this.category_path = this.rest_end_point+"brands?brand="+encodeURIComponent(this.title_search);
        else
          this.category_path = this.rest_end_point+"brands?brand="+encodeURIComponent(this.title_search)+"&category="+encodeURIComponent(value);
      }else{
        if(value == 'All')
          this.category_path = this.rest_end_point+"brands?category=";
        else
          this.category_path = this.rest_end_point+"brands?category="+encodeURIComponent(value);
      }
      axios.get(this.category_path)
      .then(response => {
        this.postList = response.data.data;
      }).catch( error => { console.log(error); });
    },
    /*Get category list*/
    getCategory() {
      axios.get(this.rest_end_point+"categories")
      .then(response => {
        this.categoryList = response.data.data;
      }).catch( error => { console.log(error); });
    },
    /*Check letter exist*/
    isExistLetter(brand){
      for(var i=0; i < this.emptybrands_alphabet.length; i++){
        if(this.emptybrands_alphabet[i] == brand || brand == 'ALL'){
          return true;
        }
      }
      return false;
    },
    /*Get letters list*/
    getLetters() {
     axios.get(this.rest_end_point+"letters")
      .then(response => {
        this.emptybrands_alphabet = response.data.data;
      }).catch( error => { console.log(error); });
    }

  }
})