rm -rf dist
npm run build
cp -r WEB-INF/ dist
cd dist
zip -r compunet-2.war *
