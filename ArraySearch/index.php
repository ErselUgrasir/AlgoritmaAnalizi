<?php

/**
 $try bir elamanın kaçıncı seferde bulunduğu
 $elemanSayisi dizinin kaç elemanlı olacağı
 $maxNumber aranacak sayının değerinin üst sınırı
 'createArray' girilen $elemanSayisi elemanlı dizi oluşturur
 'linearSearch' dizideki $arananSayi değerini artan index sırasıyla arar
 $return -1(bulunamadı) yada $try değerini döndürür
 'binarySearch' dizideki $arananSayi değerini ikili arama algoritmasıyla arar
 **/

$try = 0;

$elemanSayisi = 1000;

$maxNumber = $elemanSayisi;

$myArray = createArray($elemanSayisi);

for ($i=0; $i < 100; $i++) { 

	$arananSayi = rand(1,$maxNumber);

	// $result değeri için kullanilabilir fonksiyonlar : 'linearSearch' ve 'binarySearch'
	$result = linearSearch($myArray,$arananSayi);

	if ($result == -1) {

	echo "----- Dizide ".$arananSayi." diye bir sayı bulamadım.";

	} else {

		echo "+++".$arananSayi." sayısını ".$try.". denemede buldum.";
	}

	$try = 0;

	echo "<br />";
}

function binarySearch($myArray,$number){



}

function linearSearch($myArray,$number){

	foreach ($myArray as $value) {
		
		$GLOBALS["try"]++;

		if ($value == $number) {
			
			return $GLOBALS["try"];

		}

	}

	return -1;

}

function createArray($index){

	$arrayX = array();

	for ($i = 0; $i < $index; $i++) { 
		
		array_push($arrayX, rand(1,$GLOBALS["maxNumber"]));

	}

	sort($arrayX);

	return $arrayX;

}

?>