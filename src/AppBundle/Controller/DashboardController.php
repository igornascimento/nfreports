<?php

namespace AppBundle\Controller;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Response;

class DashboardController extends Controller
{

  /**
  * @Route("/", name="Dashboard")
  */
  public function indexAction() {
    
    $content = $this->renderView(
      'dashboard.html.php'
    );

    return new Response($content);

  }

}
