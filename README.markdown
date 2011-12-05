## vraptor-twitter

Plugin para vraptor com integração com Twitter

# instalação

Como esta dependência não se encontra no repositório maven, você tem que baixar o projeto para sua máquina e dar um mvn install.
No pom fica

		<dependency>
			<groupId>br.com.caelum.vraptor</groupId>
			<artifactId>vraptor-twitter</artifactId>
			<version>1.0.0</version>
			<scope>compile</scope>
		</dependency>
		
# configuração

Nenhuma configuração é necessária
	
# fazendo login

		import br.com.caelum.vraptor.cep.AddressFinder;
		import static br.com.caelum.vraptor.view.Results.page;
		
		@Resource
		public class MeuController {
			
			private Result result;
			private Twitter twitter;
		
			public MeuController(Twitter twitter) {
				this.twitter = twitter;
				this.result = result;
			}
			
			@Get("/login/twitter")
			public void login() {
				result.use(page()).redirectTo(provider.getLoginUrl());
			}
			
			@Get("/twitter/callback")
			public void twitterCallback(){
				TwitterProfile profile = provider.getUserProfile();
				result.include("profile", profile).redirectTo(HomeController.class).home();
			}
			
		}
		
# twittando

	@Resource
	public class TwitterController {

		private Result result;
		private Twitter twitter;

		public TwitterController(Result result, Twitter twitter){
			this.result = result;
			this.twitter = twitter;
		}

		@Get("/tweet")
		public void index(){

		}

		@Post("/tweet")
		public void tweet(String status){
			twitter.tweet(new Tweet(status));
			result.include("message", "olha o twitter").redirectTo(HomeController.class).index();
		}

	}